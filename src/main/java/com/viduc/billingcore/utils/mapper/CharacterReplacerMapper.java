package com.viduc.billingcore.utils.mapper;

import com.viduc.billingcore.utils.qualifier.CharacterReplacer;
import com.viduc.billingcore.utils.qualifier.CharacterReplacerNoHyphen;
import jakarta.validation.constraints.NotNull;

@CharacterReplacer
public class CharacterReplacerMapper {

    @CharacterReplacerNoHyphen
    public String replaceHyphen(@NotNull String value) {
         return value.replace("-" , "");
    }

}
