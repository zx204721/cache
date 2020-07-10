package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhenz
 * @description
 * @date 2020/7/10 11:44
 */
@ToString
@NoArgsConstructor
@Data
public class BaseModel {

    private Date createTime;

    private Date updateTime;
}
