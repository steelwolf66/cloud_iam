package ${package.Mapper};

import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
/**
 * <p>
    * ${table.comment!} Mapper 接口
 * </p>
**/
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends BaseMapper<${entity}> {
}
</#if>
