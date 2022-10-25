package com.jsframe.jq2day.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Member {
    String id;
    String pw;
    String name;
    int age;
}
