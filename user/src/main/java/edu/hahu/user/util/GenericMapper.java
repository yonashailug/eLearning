package edu.hahu.user.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericMapper<T, E> {
    ModelMapper modelMapper;

    @Autowired
    public GenericMapper(ModelMapper mapper) {
        this.modelMapper = mapper;
    }

    public List<E> mapList(List<T> list, Class<E> convertTo) {
        return list.stream()
                .map(item -> modelMapper.map(item, convertTo))
                .collect(Collectors.toList());

    }

    public E mapObject(T source, Class<E> target) {
        return modelMapper.map(source, target);
    }
}
