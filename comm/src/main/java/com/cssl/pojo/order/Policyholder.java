package com.cssl.pojo.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。
// 默认是假。如果fluent=true，那么chain默认为真。
public class Policyholder {
    Integer ph_id;
    String Gender;
    String passport_num;
    String Chinese_Name;
    String Date_birth;
    String ir_id;
    Integer age;
    Integer p_id;

    @Override
    public String toString() {
        return "Policyholder{" +
                "ph_id=" + ph_id +
                ", Gender='" + Gender + '\'' +
                ", passport_num='" + passport_num + '\'' +
                ", Chinese_Name='" + Chinese_Name + '\'' +
                ", Date_birth='" + Date_birth + '\'' +
                ", ir_id='" + ir_id + '\'' +
                ", age=" + age +
                ", p_id=" + p_id +
                '}';
    }
}
