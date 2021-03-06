package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;
/**
 * <p>
    * ${table.comment!} 服务实现类
    * </p>
 *
 * @since ${date}
 */
@Service
public class ${table.serviceImplName} extends ServiceImpl<${table.mapperName},${entity}> implements ${table.serviceName} {

}

