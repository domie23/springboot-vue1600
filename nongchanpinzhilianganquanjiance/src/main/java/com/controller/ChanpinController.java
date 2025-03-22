
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 产品追溯
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpin")
public class ChanpinController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinController.class);

    @Autowired
    private ChanpinService chanpinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chanpinService.queryPage(params);

        //字典表数据转换
        List<ChanpinView> list =(List<ChanpinView>)page.getList();
        for(ChanpinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinEntity chanpin = chanpinService.selectById(id);
        if(chanpin !=null){
            //entity转view
            ChanpinView view = new ChanpinView();
            BeanUtils.copyProperties( chanpin , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChanpinEntity chanpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChanpinEntity> queryWrapper = new EntityWrapper<ChanpinEntity>()
            .eq("chanpin_uuid_number", chanpin.getChanpinUuidNumber())
            .eq("chanpin_name", chanpin.getChanpinName())
            .eq("chanpin_types", chanpin.getChanpinTypes())
            .eq("chanpin_zhongzhi", chanpin.getChanpinZhongzhi())
            .eq("chanpin_jiagong", chanpin.getChanpinJiagong())
            .eq("chanpin_yunshu", chanpin.getChanpinYunshu())
            .eq("chanpin_xiaoshou", chanpin.getChanpinXiaoshou())
            .eq("chanpin_yuancailiao", chanpin.getChanpinYuancailiao())
            .eq("chanpin_zhongzi", chanpin.getChanpinZhongzi())
            .eq("chanpin_feiliao", chanpin.getChanpinFeiliao())
            .eq("chanpin_nongyao", chanpin.getChanpinNongyao())
            .eq("chanpin_number", chanpin.getChanpinNumber())
            .eq("chanpin_danwei", chanpin.getChanpinDanwei())
            .eq("chanpin_time", new SimpleDateFormat("yyyy-MM-dd").format(chanpin.getChanpinTime()))
            .eq("chanpin_baozhi", chanpin.getChanpinBaozhi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinEntity chanpinEntity = chanpinService.selectOne(queryWrapper);
        if(chanpinEntity==null){
            chanpin.setCreateTime(new Date());
            chanpinService.insert(chanpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinEntity chanpin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ChanpinEntity> queryWrapper = new EntityWrapper<ChanpinEntity>()
            .notIn("id",chanpin.getId())
            .andNew()
            .eq("chanpin_uuid_number", chanpin.getChanpinUuidNumber())
            .eq("chanpin_name", chanpin.getChanpinName())
            .eq("chanpin_types", chanpin.getChanpinTypes())
            .eq("chanpin_zhongzhi", chanpin.getChanpinZhongzhi())
            .eq("chanpin_jiagong", chanpin.getChanpinJiagong())
            .eq("chanpin_yunshu", chanpin.getChanpinYunshu())
            .eq("chanpin_xiaoshou", chanpin.getChanpinXiaoshou())
            .eq("chanpin_yuancailiao", chanpin.getChanpinYuancailiao())
            .eq("chanpin_zhongzi", chanpin.getChanpinZhongzi())
            .eq("chanpin_feiliao", chanpin.getChanpinFeiliao())
            .eq("chanpin_nongyao", chanpin.getChanpinNongyao())
            .eq("chanpin_number", chanpin.getChanpinNumber())
            .eq("chanpin_danwei", chanpin.getChanpinDanwei())
            .eq("chanpin_time", new SimpleDateFormat("yyyy-MM-dd").format(chanpin.getChanpinTime()))
            .eq("chanpin_baozhi", chanpin.getChanpinBaozhi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinEntity chanpinEntity = chanpinService.selectOne(queryWrapper);
        if("".equals(chanpin.getChanpinPhoto()) || "null".equals(chanpin.getChanpinPhoto())){
                chanpin.setChanpinPhoto(null);
        }
        if(chanpinEntity==null){
            chanpinService.updateById(chanpin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChanpinEntity> chanpinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChanpinEntity chanpinEntity = new ChanpinEntity();
//                            chanpinEntity.setChanpinUuidNumber(data.get(0));                    //追溯码 要改的
//                            chanpinEntity.setChanpinName(data.get(0));                    //产品名称 要改的
//                            chanpinEntity.setChanpinTypes(Integer.valueOf(data.get(0)));   //产品类型 要改的
//                            chanpinEntity.setChanpinPhoto("");//照片
//                            chanpinEntity.setChanpinZhongzhi(data.get(0));                    //种植企业 要改的
//                            chanpinEntity.setChanpinJiagong(data.get(0));                    //加工企业 要改的
//                            chanpinEntity.setChanpinYunshu(data.get(0));                    //运输企业 要改的
//                            chanpinEntity.setChanpinXiaoshou(data.get(0));                    //销售企业 要改的
//                            chanpinEntity.setChanpinYuancailiao(data.get(0));                    //主要原材料 要改的
//                            chanpinEntity.setChanpinZhongzi(data.get(0));                    //种子 要改的
//                            chanpinEntity.setChanpinFeiliao(data.get(0));                    //肥料 要改的
//                            chanpinEntity.setChanpinNongyao(data.get(0));                    //农药 要改的
//                            chanpinEntity.setChanpinNumber(Integer.valueOf(data.get(0)));   //数量 要改的
//                            chanpinEntity.setChanpinDanwei(data.get(0));                    //单位 要改的
//                            chanpinEntity.setChanpinTime(new Date(data.get(0)));          //生产日期 要改的
//                            chanpinEntity.setChanpinBaozhi(Integer.valueOf(data.get(0)));   //保质期(天) 要改的
//                            chanpinEntity.setCreateTime(date);//时间
                            chanpinList.add(chanpinEntity);


                            //把要查询是否重复的字段放入map中
                                //追溯码
                                if(seachFields.containsKey("chanpinUuidNumber")){
                                    List<String> chanpinUuidNumber = seachFields.get("chanpinUuidNumber");
                                    chanpinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chanpinUuidNumber = new ArrayList<>();
                                    chanpinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chanpinUuidNumber",chanpinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //追溯码
                        List<ChanpinEntity> chanpinEntities_chanpinUuidNumber = chanpinService.selectList(new EntityWrapper<ChanpinEntity>().in("chanpin_uuid_number", seachFields.get("chanpinUuidNumber")));
                        if(chanpinEntities_chanpinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChanpinEntity s:chanpinEntities_chanpinUuidNumber){
                                repeatFields.add(s.getChanpinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [追溯码] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chanpinService.insertBatch(chanpinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chanpinService.queryPage(params);

        //字典表数据转换
        List<ChanpinView> list =(List<ChanpinView>)page.getList();
        for(ChanpinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinEntity chanpin = chanpinService.selectById(id);
            if(chanpin !=null){


                //entity转view
                ChanpinView view = new ChanpinView();
                BeanUtils.copyProperties( chanpin , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChanpinEntity chanpin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());
        Wrapper<ChanpinEntity> queryWrapper = new EntityWrapper<ChanpinEntity>()
            .eq("chanpin_uuid_number", chanpin.getChanpinUuidNumber())
            .eq("chanpin_name", chanpin.getChanpinName())
            .eq("chanpin_types", chanpin.getChanpinTypes())
            .eq("chanpin_zhongzhi", chanpin.getChanpinZhongzhi())
            .eq("chanpin_jiagong", chanpin.getChanpinJiagong())
            .eq("chanpin_yunshu", chanpin.getChanpinYunshu())
            .eq("chanpin_xiaoshou", chanpin.getChanpinXiaoshou())
            .eq("chanpin_yuancailiao", chanpin.getChanpinYuancailiao())
            .eq("chanpin_zhongzi", chanpin.getChanpinZhongzi())
            .eq("chanpin_feiliao", chanpin.getChanpinFeiliao())
            .eq("chanpin_nongyao", chanpin.getChanpinNongyao())
            .eq("chanpin_number", chanpin.getChanpinNumber())
            .eq("chanpin_danwei", chanpin.getChanpinDanwei())
            .eq("chanpin_baozhi", chanpin.getChanpinBaozhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinEntity chanpinEntity = chanpinService.selectOne(queryWrapper);
        if(chanpinEntity==null){
            chanpin.setCreateTime(new Date());
        chanpinService.insert(chanpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
