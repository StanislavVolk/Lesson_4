package builder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .setName("Stanislav")
                .setSurname("Volkov")
                .setAddres("Alma-Ata")
                .setEmale("stanislav.almaty@gmail.com")
                .build();
        RequestSpecification requestSpecification =
              new RequestSpecBuilder().build();
        //System.out.println(user.getName());
    }

}
