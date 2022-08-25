package com.jb.rickAndMor.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kobis on 26 Apr, 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrDetails {

    private String key;
    private String value;
}
