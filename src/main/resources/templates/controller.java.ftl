package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{
<#else>public class ${table.controllerName} {
</#if>

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    @PostMapping()
    public ApiResult add(@RequestBody ${entity} ${entity?uncap_first}){
        return ApiResult.success(${(table.serviceName?substring(1))?uncap_first}.add(${entity?uncap_first}));
    }

    @DeleteMapping("{id}")
    public ApiResult delete(@PathVariable("id") Long id){
        return ApiResult.success(${(table.serviceName?substring(1))?uncap_first}.delete(id));
    }

    @PutMapping()
    public ApiResult update(@RequestBody ${entity} ${entity?uncap_first}){
        return ApiResult.success(${(table.serviceName?substring(1))?uncap_first}.updateData(${entity?uncap_first}));
    }

    @GetMapping()
    public ApiResult findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return ApiResult.success(${(table.serviceName?substring(1))?uncap_first}.findListByPage(current, pageSize));
    }

    @GetMapping("{id}")
    public ApiResult findById(@PathVariable Long id){
        return ApiResult.success(${(table.serviceName?substring(1))?uncap_first}.findById(id));
    }

}
</#if>