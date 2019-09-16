package by.falizyers.myhome.core.entity;

import by.falizyers.myhome.core.dto.UserPermissionsType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_permissions")
public class UserPermissionsEntity implements PersistentEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "upns_id")
    private Long id;

    @Column(name = "upns_type")
    @Enumerated
    private UserPermissionsType type;

    @Column(name = "upns_name")
    private String name;
}
