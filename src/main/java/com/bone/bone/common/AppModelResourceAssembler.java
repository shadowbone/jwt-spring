package com.bone.bone.common;

import com.bone.bone.controllers.AppController;
import com.bone.bone.models.AppModel;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class AppModelResourceAssembler implements ResourceAssembler<AppModel, Resource<AppModel>> {

    public Resource toResource(AppModel entity) {
        Resource<AppModel> resource = new Resource<>(entity);
        return resource;
    }
    public void addLinks(Resource<AppModel> resource) {
        resource.add(linkTo(AppController.class).slash(resource.getContent()).withSelfRel());
    }
}
