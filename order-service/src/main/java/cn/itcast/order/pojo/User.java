package cn.itcast.order.pojo;

/**
 * @author zhengpeijian
 * @date 2021/10/9 21:28
 */
import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String address;
}
