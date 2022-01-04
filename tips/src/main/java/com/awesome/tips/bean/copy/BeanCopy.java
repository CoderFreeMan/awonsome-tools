package com.awesome.tips.bean.copy;

import com.awesome.tips.DO.PersonDO;
import com.awesome.tips.DTO.PersonDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.StopWatch;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

/**
 * @author yangdejun
 * @date 2020/09/01
 **/
public class BeanCopy {

    static HashMap<String, String> counter;

    static {
        HashMap<String, String> stringIntegerHashMap = new HashMap<>(5);
        counter = stringIntegerHashMap;
    }

    static void mappingBySpringBeanUtils(PersonDO personDO, int times) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < times; i++) {
            PersonDTO personDTO = new PersonDTO();
            copyProperties(personDO, personDTO);
        }
        stopWatch.stop();
        counter.put("spring", String.valueOf(stopWatch.getTotalTimeMillis()));
        System.out.println("mappingBySpringBeanUtils cost: " + stopWatch.getTotalTimeMillis());
    }

    static void mappingByCglibBeanCopier(PersonDO personDO, int times) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < times; i++) {
            PersonDTO personDTO = new PersonDTO();
            BeanCopier copier = BeanCopier.create(PersonDO.class, PersonDTO.class, false);
            copier.copy(personDO, personDTO, null);
        }
        stopWatch.stop();
        counter.put("cglib", String.valueOf(stopWatch.getTotalTimeMillis()));
        System.out.println("mappingByCglibBeanCopier cost: " + stopWatch.getTotalTimeMillis());
    }

    /**
     * Apache BeanUtils
     * @param personDO
     * @param times
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    static void mappingByApacheBeanUtils(PersonDO personDO, int times) throws InvocationTargetException, IllegalAccessException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < times; i++) {
            PersonDTO personDTO = new PersonDTO();
            BeanUtils.copyProperties(personDTO, personDO);
        }
        stopWatch.stop();
        counter.put("apacheBeanUtils", String.valueOf(stopWatch.getTotalTimeMillis()));
        System.out.println("mappingByApacheBeanUtils cost: " + stopWatch.getTotalTimeMillis());
    }

    static void mappingByApachePropertyUtils(PersonDO personDO, int times) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < times; i++) {
            PersonDTO personDTO = new PersonDTO();
            PropertyUtils.copyProperties(personDTO, personDO);
        }
        stopWatch.stop();
        counter.put("apachePropertyUtils", String.valueOf(stopWatch.getTotalTimeMillis()));
        System.out.println("mappingByApachePropertyUtils cost: " + stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        PersonDO personDO = new PersonDO();
        personDO.setName("Mr.yang");
        personDO.setAge(26);
        personDO.setBirthday(new Date());
        personDO.setId(1);
        Thread.sleep(3000);

//        mappingBySpringBeanUtils(personDO, 1000);
//        mappingByCglibBeanCopier(personDO, 1000);
//        mappingByApacheBeanUtils(personDO, 1000);
//        mappingByApachePropertyUtils(personDO, 1000);
        System.out.println("************************");
//        mappingBySpringBeanUtils(personDO, 10000);
//        mappingByCglibBeanCopier(personDO, 10000);
//        mappingByApacheBeanUtils(personDO, 10000);
//        mappingByApachePropertyUtils(personDO, 10000);
        System.out.println("************************");
//        mappingBySpringBeanUtils(personDO, 100000);
//        mappingByCglibBeanCopier(personDO, 100000);
//        mappingByApacheBeanUtils(personDO, 100000);
//        mappingByApachePropertyUtils(personDO, 100000);
        System.out.println("************************");
        mappingBySpringBeanUtils(personDO, 1000000);
        mappingByCglibBeanCopier(personDO, 1000000);
        mappingByApacheBeanUtils(personDO, 1000000);
        mappingByApachePropertyUtils(personDO, 1000000);

        System.out.println("========================");

        counter.forEach((K, V) -> {
            System.out.println(K + "->" + V);
        });
    }
}
