/*import java.util.List;
import java.util.Comparator;
import com.example.amazonproject.service.UsersService;
import com.example.amazonproject.entity.Users;
import com.example.amazonproject.entity.Leads;
import org.springframework.beans.factory.annotation.Autowired;
public class Service {
	@Autowired
	private UsersService usobj;
	Comparator<Users> RankComparator = new Comparator<Users>() {
        @Override
        public int compare(Users u1, Users u2) {
        	if(u1.getCountOfLeads()==usobj.getMaxLeadsCount()) {
        		return -1;
        	}
        	int r1=u1.getRank();
        	int r2=u2.getRank();
            return (r2-r1);
        }
    };
	public String assignLeads(List<Leads> leads) {
		for(Leads l : leads) {
			String loc=l.getLocation();
			List<Users> users=usobj.findByLocation(loc);
			boolean assign=false;
			for(Users u: users) {
				if(u.getCountOfLeads()<usobj.getMaxLeadsCount()) {
					l.setUser(u);
					u.setCountOfLeads(u.getCountOfLeads()+1);
					assign=true;
					break;
				}
			}
			if(assign==false) {
				int min=usobj.getMinLeadsCount();
				List<Users> defaultusers=usobj.findByCountOfLeads(min);
				Users u=defaultusers.get(0);
				u.setCountOfLeads(u.getCountOfLeads()+1);
			}
		}
		return "assigned";
	}
}*/