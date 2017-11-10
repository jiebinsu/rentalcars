package su.jiebin.search;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void vehiclesApiExists() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("vehicles")));
    }
	
	@Test
    public void firstVehicleId() throws Exception {
        this.mockMvc.perform(get("/vehicles/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("1")));
    }
	
	@Test
    public void firstVehicleName() throws Exception {
        this.mockMvc.perform(get("/vehicles/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Ford Focus")));
    }
	
	@Test
    public void firstVehicleCarType() throws Exception {
        this.mockMvc.perform(get("/vehicles/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].carType", is("Compact")));
    }
	
	@Test
    public void firstVehicleDoorType() throws Exception {
        this.mockMvc.perform(get("/vehicles/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].doorType", is("5 doors")));
    }
	
	@Test
    public void firstVehicleTransmissionType() throws Exception {
        this.mockMvc.perform(get("/vehicles/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].transmissionType", is("Manual")));
    }
	
	@Test
    public void firstVehicleScore() throws Exception {
        this.mockMvc.perform(get("/vehicles/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].score", is("3")));
    }
	
	@Test
    public void firstVehicleTotalScore() throws Exception {
        this.mockMvc.perform(get("/vehicles/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].totalScore", is("11.9")));
    }

}
