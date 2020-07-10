package model.simple;

import lombok.Data;
import model.BaseModel;

/**
 * @author zhenz
 * @description 简单用户实体类
 * @date 2020/7/10 11:38
 */
@Data
public class User extends BaseModel {

    private long id;

    private String username;

    private String password;

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
