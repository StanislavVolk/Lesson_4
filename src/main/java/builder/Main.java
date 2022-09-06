package builder;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .setName("Stanislav")
                .setSurname("Volkov")
                .setAddres("Alma-Ata")
                .setEmale("stanislav.almaty@gmail.com")
                .build();
    }
}
