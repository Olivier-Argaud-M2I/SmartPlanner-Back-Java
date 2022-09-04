package fr.m2i.smartplanner.services;



import fr.m2i.smartplanner.dtos.UserDto;
import fr.m2i.smartplanner.models.JwtResponse;
import fr.m2i.smartplanner.models.User;
import fr.m2i.smartplanner.utils.JwtUtil;

import java.util.HashSet;
import java.util.Set;


public class JwtService{


    private JwtUtil jwtUtil = new JwtUtil();


    public JwtResponse createJwtToken(User user) throws Exception {
        String newGeneratedToken = jwtUtil.generateToken(user);
        return new JwtResponse(new UserDto(user), newGeneratedToken);
    }



//    private Set getAuthority(Utilisateur user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        });
//        return authorities;
//    }


}
