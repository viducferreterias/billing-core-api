package com.viduc.billingcore.repository.configuration;

import com.viduc.billingcore.domain.Setting;
import com.viduc.billingcore.domain.Setting_;
import com.viduc.billingcore.dto.components.SettingProfileDto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@NoArgsConstructor
@Stateless
public class ConfigurationRepository {


    public List<Setting> getConfiguration(EntityManager em , SettingProfileDto settingProfile) {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(Setting.class);
        var setting = criteria.from(Setting.class);

        var predicates = new ArrayList<Predicate>();

        if (settingProfile.getConfiguration() != null) {
            predicates.add(builder.equal(setting.get(Setting_.configuration) , settingProfile.getConfiguration()));
        }


        log.info(settingProfile.toString());

        criteria.select(setting);
        criteria.where(builder.equal(setting.get(Setting_.state) , 1),
                builder.equal(builder.coalesce(setting.get(Setting_.application) , "null") , Optional.ofNullable(settingProfile.getApplication()).orElse("null")),
                builder.equal(builder.coalesce(setting.get(Setting_.module) ,"null") , Optional.ofNullable(settingProfile.getModule()).orElse("null")),
                builder.equal(builder.coalesce(setting.get(Setting_.parameter) , 0) , Optional.ofNullable(settingProfile.getParameter()).orElse(0)),
                builder.equal(builder.coalesce(setting.get(Setting_.format) , "null") , Optional.ofNullable(settingProfile.getFormat()).orElse("null")),
                builder.equal(builder.coalesce(setting.get(Setting_.type) , "null") , Optional.ofNullable(settingProfile.getType()).orElse("null")),
                builder.and(predicates.toArray(new Predicate[]{})));

        return em.createQuery(criteria).getResultList();

    }


}
