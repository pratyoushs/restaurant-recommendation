/*
package com.webapp.rr;
import com.webapp.rr.domain.User;
import com.webapp.rr.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RestaurantRecommendationApplicationTests {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        UserService service = (UserService) context.getBean("UserService");

        // Please uncomment one of the operation section
        // and comment remaining section to test only one operation at a time
        // Here I've uncommented CREATE operation and
        // commented other operations: FIND ONE, FIND ALL, DELETE
        // CREATE Operation
        User user = createPofile();
        createProfile(service,user);
        System.out.println("User created successfully.");

        // FIND ONE
      */
/*
      GoogleProfile profile = getOneProfileById(service,67515L);		
      System.out.println(profile);
      *//*


        // FIND ALL
      */
/*
      getAllProfiles(service);		
      *//*


        // DELETE
      */
/*
      GoogleProfile profile = createPofile();
      deleteProfile(service,profile);		
      System.out.println("GoogleProfile deleted successfully.");		
      *//*

    }

    private static User createProfile(UserService service, User user){
        return service.create(user);
    }

*/
/*	private static void deleteProfile(GoogleProfileService service,GoogleProfile profile){
		service.delete(profile);
	}

	private static GoogleProfile getOneProfileById(GoogleProfileService service,Long id){
		return service.findById(id);
	}

	private static void getAllProfiles(GoogleProfileService service){
		Result<GoogleProfile> result = service.findAll();
		Iterator<GoogleProfile> iterator = result.iterator();

		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}*//*


    private static User createPofile(){
        User user = new User();
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setAddress("Hyderabad");
        user.setGender("Male");
        return user;
    }
}*/
