package com.neo.dao;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 *
 * ClassName: PersistentDO <br/>
 * Function: 持久化的实体类. <br/>
 * Reason: 提供持久化的实体. <br/>
 * date: 2017年2月27日 下午2:18:39 <br/>
 *
 *
 * @version
 * @since
 */
public abstract class PersistentDO  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(o, this, false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
