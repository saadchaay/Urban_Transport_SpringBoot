package com.urban.usersservice.utils;

import com.urban.usersservice.dtos.transporter.TransporterInputDto;
import com.urban.usersservice.dtos.users.UserInputDto;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.List;

@Component
public class KeycloakUtil {

    @Value("${kc.serverUrl}")
    private String serverUrl;
//    private String serverUrl = "http://localhost:8080/auth";

    @Value("${kc.realm}")
    private String realm;

    @Value("${kc.clientId}")
    private String clientId;

    @Value("${kc.username}")
    private String username;

    @Value("${kc.password}")
    private String password;


    public Keycloak getAdminKeycloakUser() {
        System.out.println("------------------------------------------"+serverUrl);
        System.out.println("------------------------------------------"+realm);
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .grantType("password")
                .realm(realm)
                .clientId(clientId)
                .username(username)
                .password(password)
                .build();
    }

    public RealmResource getRealm() {
        return getAdminKeycloakUser().realm("urban-transport");
    }

    public void setCredentials(String userId, String password){
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType("password");
        credentialRepresentation.setValue(password);
        UserResource userResource = getRealm().users().get(userId);
        userResource.resetPassword(credentialRepresentation);
    }

    public void addTransporterRole(String userId, String assignedRole){
        RoleRepresentation role = getRealm().roles().get(assignedRole).toRepresentation();
        UserResource userResource = getRealm().users().get(userId);
        userResource.roles().realmLevel().add(List.of(role));
    }

    public void createKeycloakTransporterWithRole(TransporterInputDto trDto, String password){
        UserRepresentation tranRepresent = new UserRepresentation();
        tranRepresent.setLastName(trDto.getName());
        tranRepresent.setFirstName(trDto.getName());
        tranRepresent.setUsername(trDto.getEmail());
        tranRepresent.setEnabled(true);
        tranRepresent.setEmail(trDto.getEmail());
        Response response = getRealm().users().create(tranRepresent);
        String tranId = CreatedResponseUtil.getCreatedId(response);
        setCredentials(tranId, password);
        addTransporterRole(tranId, "TRANSPORTER");
    }

    public void createKeycloakUserWithRole(UserInputDto userDto, String password){
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setLastName(userDto.getName());
        userRepresentation.setFirstName(userDto.getName());
        userRepresentation.setUsername(userDto.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmail(userDto.getEmail());
        Response response = getRealm().users().create(userRepresentation);
        String userId = CreatedResponseUtil.getCreatedId(response);
        setCredentials(userId, password);
        addTransporterRole(userId, "USER");
    }

}
