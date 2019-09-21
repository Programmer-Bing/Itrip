package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class citiesstates {

    int cs_id;
    String cs_name;
    int sp_id;
    int Popular;
    int sb_cs;
    String img;

}
