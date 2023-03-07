package com.urban.usersservice.entities.projections;

import com.urban.usersservice.entities.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "full-user", types = User.class)
public interface UserProjection {
    Long getId();
    String getName();
    String getEmail();
    String getPhone();
    String getAddress();
    String getPicture();
    String getIdentity();
    String getPassword();
}
