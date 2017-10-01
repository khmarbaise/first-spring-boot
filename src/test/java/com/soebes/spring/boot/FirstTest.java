package com.soebes.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This integration test starts up the whole application and tests the responses it get from the application.
 * 
 * @author Karl Heinz Marbaise
 */
@RunWith( SpringRunner.class )
@WebMvcTest( HelloController.class )
public class FirstTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRoot() throws Exception
    {
        mockMvc.perform( get( "/" ) )
            .andExpect( status().isOk() )
            .andExpect( content().string( "Greetings from Spring Boot!" ) );
    }

    @Test
    public void getLists() throws Exception
    {
        mockMvc.perform( get( "/lists" ) )
            .andExpect( status().isOk() )
            .andExpect( content().string( "Something different." ) );
    }
}
