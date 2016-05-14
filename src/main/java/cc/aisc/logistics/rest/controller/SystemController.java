package cc.aisc.logistics.rest.controller;

import cc.aisc.commons.helper.TreeHelper;
import cc.aisc.logistics.model.sys.Category;
import cc.aisc.logistics.model.sys.Menu;
import cc.aisc.logistics.model.sys.type.CategoryType;
import cc.aisc.logistics.rest.exception.DataBindingException;
import cc.aisc.logistics.service.system.CategoryService;
import cc.aisc.logistics.service.system.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-5-13.
 */
@RestController
@RequestMapping("/system")
public class SystemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MenuService menuService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd");
        binder.addCustomFormatter(dateFormatter);
    }
    /*CRUD for CATEGORY start*/
    @RequestMapping(value = "/categories/type/{type}", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategoriesByType(@PathVariable("type") String type) throws Exception {
        Optional<List<Category>> results = categoryService.findAllByType(CategoryType.valueOf(type.toUpperCase()));
        if (results.isPresent() && results.get().size() > 0){
            List<Category> list = ((List<Category>)results.get());
            TreeHelper<Category> helper = new TreeHelper<>();
            return ResponseEntity.ok(helper.getTree(list));
        }else {
            throw new NoSuchElementException("NO such element.");
        }
    }
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories() throws Exception {
        Optional<Collection<Category>> results = categoryService.findAll();
        if (results.isPresent() && results.get().size() > 0){
            List<Category> list = ((List<Category>)results.get());
            TreeHelper<Category> helper = new TreeHelper<>();
            return ResponseEntity.ok(helper.getTree(list));
        }else {
            throw new NoSuchElementException("NO such element.");
        }
    }
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoriesById(@PathVariable Long id) throws Exception{
        Optional<Category> location = categoryService.findById(id);
        if (location.isPresent())
            return ResponseEntity.ok(location.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<Category> addCategory(@Valid @ModelAttribute Category record,
                                                          BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        categoryService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCategory(@Valid @ModelAttribute Category record,
                                                BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        categoryService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception{
        categoryService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for CATEGORY end*/

    /*CRUD for MENU start*/
    @RequestMapping(value = "/menus/level/{lvl}", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> getMenusByLevelLe(@PathVariable Integer lvl) throws Exception {
        Optional<List<Menu>> results = menuService.findByLevelLe(lvl);
        if (results.isPresent() && results.get().size() > 0){
            List<Menu> list = ((List<Menu>)results.get());
            TreeHelper<Menu> helper = new TreeHelper<>();
            return ResponseEntity.ok(helper.getTree(list));
        }else {
            throw new NoSuchElementException("NO such element.");
        }
    }
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> getMenus() throws Exception {
        Optional<Collection<Menu>> results = menuService.findAll();
        if (results.isPresent() && results.get().size() > 0){
            List<Menu> list = ((List<Menu>)results.get());
            TreeHelper<Menu> helper = new TreeHelper<>();
            return ResponseEntity.ok(helper.getTree(list));
        }else {
            throw new NoSuchElementException("NO such element.");
        }
    }
    @RequestMapping(value = "/menus/{id}", method = RequestMethod.GET)
    public ResponseEntity<Menu> getMenusById(@PathVariable Long id) throws Exception{
        Optional<Menu> location = menuService.findById(id);
        if (location.isPresent())
            return ResponseEntity.ok(location.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    public ResponseEntity<Menu> addMenu(@Valid @ModelAttribute Menu record,
                                                          BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        menuService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/menus", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrailer(@Valid @ModelAttribute Menu record,
                                                BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        menuService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMenu(@PathVariable Long id) throws Exception{
        menuService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for MENU end*/

}
