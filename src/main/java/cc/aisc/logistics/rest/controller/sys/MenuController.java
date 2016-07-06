package cc.aisc.logistics.rest.controller.sys;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.helper.TreeHelper;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.sys.Menu;
import cc.aisc.logistics.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class MenuController extends AbstractController<Menu, Long> implements IMenuController {

    @Autowired
    private MenuService menuService;

    private final static String PATH_SYS = "/sys";
    private final static String PATH_END = "/menus";

    @Override
    @RequestMapping(value = PATH_SYS + PATH_END + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    @Override
    @RequestMapping(value = PATH_SYS + PATH_END + "/query", method = RequestMethod.GET)
    public ResponseEntity<Response> find(@RequestParam("param") Object o) throws Exception {
        return super.find(o);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = PATH_SYS + PATH_END, method = RequestMethod.GET)
    public ResponseEntity<Response> get() throws Exception {
        Optional<Collection<Menu>> results = (Optional<Collection<Menu>>) menuService.findAll();
        if (results.isPresent() && results.get().size() > 0){
            List<Menu> list = ((List<Menu>)results.get());
            TreeHelper<Menu> helper = new TreeHelper<>();
            return ResponseEntity.ok(new Response(1, true, "查询成功", helper.getTree(list)));
        }else {
            throw new NoSuchElementException("无数据");
        }
    }

    @Override
    @RequestMapping(value = PATH_SYS + PATH_END, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) Menu record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS + PATH_END, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) Menu record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS + PATH_END + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }
}