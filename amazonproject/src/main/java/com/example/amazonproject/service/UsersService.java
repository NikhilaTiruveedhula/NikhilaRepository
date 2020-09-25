package com.example.amazonproject.service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import com.example.amazonproject.dao.UsersDaoInterface;
import com.example.amazonproject.entity.Users;
import com.example.amazonproject.entity.Leads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("usersservice")
public class UsersService implements UsersServiceInterface{
	@Autowired
	@Qualifier("usersdao")
	private UsersDaoInterface ob;
	public int cachevar=10;
	public int minvar=0;
	public int getMaxLeadsCount() {
		return cachevar;
	}
	public void setMaxLeadsCount(int cachevar) {
		this.cachevar=cachevar;
	}
	public int getMinLeadsCount() {
		return minvar;
	}
	public void setMinLeadsCount(int minvar) {
		this.minvar=minvar;
	}
	public Users saveUser(Users user) {
		return ob.save(user);
	}
	public List<Users> saveUsers(List<Users> users) {
		return ob.saveAll(users);
	}
	public Users getUserById(int id) {
		return ob.findById(id).orElse(null);
	}
	public List<Users> getUsers() {
		return ob.findAll();
	}
	public String deleteUsersById(int id) {
		ob.deleteById(id);
		return "user removed";
	}
	public Users updateUser(Users user) {
		Users exist=ob.findById(user.getId()).orElse(null);
		exist.setContactNo(user.getContactNo());
		exist.setRank(user.getRank());
		exist.setName(user.getName());
		exist.setEmailId(user.getEmailId());
		exist.setLocation(user.getLocation());
		return ob.save(exist);
	}
	public Optional<Users> findByLocation(String location){
		return ob.findByLocation(location);
	}
	public Optional<Users> findByCountOfLeads(int min){
		return ob.findByCountOfLeads(min);
	}
	public String assignLeads(List<Leads> leads) {
		for(Leads l : leads) {
			String loc=l.getLocation();
			Optional<Users> list=ob.findByLocation(loc);
			List<Users> users=new ArrayList<Users>();
			if(list.isPresent()) {
				users.add(list.get());
			}
			boolean assign=false;
			for(Users u: users) {
				if(u.getCountOfLeads()<this.getMaxLeadsCount()) {
					l.setUser(u);
					u.setCountOfLeads(u.getCountOfLeads()+1);
					assign=true;
					break;
				}
			}
			if(assign==false) {
				int min=this.getMinLeadsCount();
				Optional<Users> dfusr=ob.findByCountOfLeads(min);
				List<Users> defaultusers=new ArrayList<Users>();
				if(list.isPresent()) {
					defaultusers.add(dfusr.get());
				}
				Users u=defaultusers.get(0);
				u.setCountOfLeads(u.getCountOfLeads()+1);
			}
		}
		return "assigned";
	}
}
