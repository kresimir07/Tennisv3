package org.example.tennisv3.demo;
import lombok.Data;
import org.example.tennisv3.model.Court;
import org.example.tennisv3.model.Role;
import org.example.tennisv3.model.Surface;
import org.example.tennisv3.model.User;
import org.example.tennisv3.service.CourtService;
import org.example.tennisv3.service.RoleService;
import org.example.tennisv3.service.SurfaceService;
import org.example.tennisv3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Data
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final SurfaceService surfaceService;
    private final CourtService courtService;

    @Override
    public void run(String... args) {
        roleService.newRole(new Role("ROLE_USER"));
        roleService.newRole(new Role("ROLE_ADMIN"));


        userService.saveUser(new User("Mario Maric", "mmaric", "1234"));
        userService.saveUser(new User("Kruno Vulic", "kvulic", "1234"));
        userService.saveUser(new User("Valentina Vulic", "vvulic", "1234"));
        userService.saveUser(new User("Hana Colic", "hcolic", "1234"));

        roleService.addOrModifyRoleToUser("mmaric", "ROLE_USER");
        roleService.addOrModifyRoleToUser("kvulic", "ROLE_ADMIN");
        roleService.addOrModifyRoleToUser("vvulic", "ROLE_USER");
        roleService.addOrModifyRoleToUser("hcolic", "ROLE_ADMIN");

        // Save surface - had to declare variables first
        Surface clay = surfaceService.newSurface(new Surface("Clay"));
        Surface grass = surfaceService.newSurface(new Surface("Grass"));
        Surface hard = surfaceService.newSurface(new Surface("Hard"));
        Surface carpet = surfaceService.newSurface(new Surface("Carpet"));


        // Save courts - able to save with above surface variables
        courtService.saveCourtName(new Court("Court A", clay, FALSE));
        courtService.saveCourtName(new Court("Court B", clay, FALSE));
        courtService.saveCourtName(new Court("Court C", hard, FALSE));
        courtService.saveCourtName(new Court("Court D", hard, TRUE));
    }



}

