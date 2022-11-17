package userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
        private int id;
        private String name;
        private String color;

}
