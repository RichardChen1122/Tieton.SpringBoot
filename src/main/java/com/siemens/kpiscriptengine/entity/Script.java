package com.siemens.kpiscriptengine.entity;

import java.util.List;
import com.siemens.kpiscriptengine.usertype.JsonType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.siemens.kpiscriptengine.dto.ScriptLine;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "datasets")
@TypeDefs({ @TypeDef(name = "JSONObjectType", typeClass = JsonType.class, parameters = {
        @org.hibernate.annotations.Parameter(name = JsonType.CLASS, value = "com.alibaba.fastjson.JSONObject") }),
        @TypeDef(name = "RangeType", typeClass = JsonType.class, parameters = {
                @org.hibernate.annotations.Parameter(name = JsonType.CLASS, value = "com.siemens.dashboard.entity.Range") }) })
public class Script extends EntityBase {
    @Column(name = "scriptBlock", columnDefinition = "json")
    @Type(type = "JSONObjectType")
    private List<ScriptLine> scriptBlock;

    public List<ScriptLine> getScriptBlock() {
        return scriptBlock;
    }

    public void setScriptBlock(List<ScriptLine> scriptBlock) {
        this.scriptBlock = scriptBlock;
    }

}