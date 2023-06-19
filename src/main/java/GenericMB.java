import lombok.Data;

import javax.inject.Named;

@Named
@Data
public class GenericMB {
    private String text = "test ssfafd gafd";

    public void texts () {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
