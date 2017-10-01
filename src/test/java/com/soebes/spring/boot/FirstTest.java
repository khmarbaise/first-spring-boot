package com.soebes.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * This integration test starts up the whole application
 * and tests the responses it get from the application.
 * 
 * @author Karl Heinz Marbaise
 *
 */
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT )
@DirtiesContext
public class FirstTest
    extends AbstractTestNGSpringContextTests
{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHome()
    {
        ResponseEntity<String> entity = this.restTemplate.getForEntity( "/", String.class );
        assertThat( entity.getStatusCode() ).isEqualTo( HttpStatus.OK );
        assertThat( entity.getBody() ).isEqualTo( "Greetings from Spring Boot!" );
    }
    @Test
    public void testGetLists()
    {
        ResponseEntity<String> entity = this.restTemplate.getForEntity( "/lists", String.class );
        assertThat( entity.getStatusCode() ).isEqualTo( HttpStatus.OK );
        assertThat( entity.getBody() ).isEqualTo( "Something different." );
    }
}
