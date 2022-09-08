package utils;

import fr.m2i.smartplanner.models.User;
import fr.m2i.smartplanner.utils.JwtUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;


public class JwtUtilTest {


    private JwtUtil jwtUtil;

    @BeforeEach
    public void init(){
        jwtUtil = new JwtUtil();
    }

    @Test
    public void generateToken(){

        User user = new User();
        user.setPassword("admin");
        user.setUserName("admin");

        String newGeneratedToken = jwtUtil.generateToken(user,new Date(0),new Date(0+(3600 * 5 * 1000)));

        Assertions.assertThat(newGeneratedToken).isEqualTo("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTgwMDAsImlhdCI6MH0.VDD_9Vln875WYS4KpZmrJZc_e3Pgmih3UQNwKyIliJE6a9u-Wjsz7tnYI-g-Cgxe0enjlzJliT3krbP1CiyenA");


    }
}
