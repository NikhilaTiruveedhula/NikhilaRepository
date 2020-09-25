package com.example.amazonproject;
/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan("com.example.entity")
@SpringBootApplication
public class AmazonprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(AmazonprojectApplication.class, args);
	}
}
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import com.example.amazonproject.entity.Leads;
import com.example.amazonproject.entity.Users;
import com.example.amazonproject.service.LeadsService;
import com.example.amazonproject.service.UsersService;
@SpringBootApplication
@ComponentScan({"com.example.amazonproject.service" ,"com.example.amazonproject.dao","com.example.amazonproject.entity"})
@EntityScan("com.example.amazonproject.entity")
@EnableJpaRepositories("com.example.amazonproject.dao")
public class AmazonprojectApplication implements CommandLineRunner {
    @Autowired
    @Qualifier("leadsservice")
    private LeadsService ls;
    @Autowired
    @Qualifier("usersservice")
    private UsersService us;
    public static void main(String[] args) {
        SpringApplication.run(AmazonprojectApplication.class, args);
       
    }
    @Override
    public void run(String... args) throws Exception {
        Leads lead=new Leads();
        lead.setId(2);
        lead.setContactNo(Long.parseLong("9100796289"));
        lead.setEmailId("aastha123@gmail.com");
        lead.setLeadsource("web");
        lead.setLocation("Hyderabad");
        lead.setName("Pastha");
        lead.setScore(10);
        lead.setType("new");
        ls.saveLead(lead);
        List<Leads> retrieved=ls.getLeads();
        for(Leads x: retrieved)
        	System.out.println(x.getName());
        Users user=new Users();
        user.setContactNo(Long.parseLong("9290173558"));
        user.setCountOfLeads(0);
        user.setEmailId("sita@gmail.com");
        user.setId(1);
        user.setLocation("Delhi");
        user.setName("Sita");
        user.setRank(1);
        us.saveUser(user);
        List<Users> retrieved2=us.getUsers();
        for(Users x: retrieved2)
        	System.out.println("users info"+x.getName());
   }
}