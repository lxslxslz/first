package edu.etime.tsly.admin.controllers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.etime.tsly.admin.services.interfaces.AdminSysAreaService;
import edu.etime.tsly.pojo.SysArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 景点地域管理控制层
 */
@Controller
@RequestMapping("/admin/sys/area")
@ResponseBody
public class AdminSysAreaController {
    @Autowired
    private AdminSysAreaService service;

    /**
     * 增加景点地域
     * @param area 主键areaid不需要赋值
     * @return
     */
    @GetMapping("/insert")
    public int insertSysarea(SysArea area){
        int rtn = service.insertSysArea(area);
        System.out.println(area);
        return rtn;
    }

    /**
     * 修改方法
     *
     * @param area 需要根据id进行修改
     * @return
     */
    @GetMapping("/update")
    public int uodateSysArea(SysArea area){
        return  service.updateSysArea(area);
    }

    /**
     * 根据id查询一条地域的详细信息
     * @param areaid 景点地域id
     * @return 景点详细信息
     */
    @GetMapping("/get/{areaid}")
    public  SysArea selectSysAreaById(@PathVariable("areaid") long areaid){
        return service.selectSysAreaById(areaid);
    }

    /**
     * 查看景点地域列表
     * @param area 如果需要查询可用的地域：areastate=1
     * @return
     */

    @RequestMapping("/list")
    public List<SysArea> selectSysAreaList(SysArea area){
        return service.selectSysAreaList(area);
    }

    /**
     * 分页查询
     * @param area 条件查询
     * @param pagenum 当前第几页
     * @param pagesize 每页多少行
     * @return
     */
   public Page<SysArea> selectSysAreaByPage(SysArea area,long pagenum,long pagesize){
        return service.selectSysAreaListByPage(area,pagenum,pagesize);


   }
}
