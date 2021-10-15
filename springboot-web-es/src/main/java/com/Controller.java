package com;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/es")
public class Controller {

    @Resource
    PersonRepository personRepository;

    @Resource
    ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/add")
    public void add() {
        Person person = new Person();
        person.setFirst_name("张");
        person.setLast_name("三");
        person.setAge(18);
        person.setHeight(175);
        person.setWeight(50);
        personRepository.save(person);
    }

    @RequestMapping(value = "/query/{search}", method = RequestMethod.GET)
    @ResponseBody
    public List query(@PathVariable("search") String search) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(search);
        Iterable<Person> searchResult = personRepository.search(builder);
        Iterator<Person> iterator = searchResult.iterator();
        List<Person> list = new ArrayList();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
