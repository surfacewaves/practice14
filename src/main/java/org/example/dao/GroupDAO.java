package org.example.dao;

import org.example.model.Group;
import org.example.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupDAO {
    private static int GROUP_COUNT;
    private List<Group> groups;

    {
        groups = new ArrayList<>();

        groups.add(new Group("IKBO-24-21", ++GROUP_COUNT));
    }

    public List<Group> index() {
        return groups;
    }

    public Group show(int id) {
        return groups.stream().filter(group -> group.getId() == id).findAny().orElse(null);
    }

    public void save(Group group) {
        group.setId(++GROUP_COUNT);
        groups.add(group);
    }

    public void update(int id, Group group) {
        Group groupToBeUpdated = show(id);
        groupToBeUpdated.setName(group.getName());
    }

    public void delete(int id) {
        groups.removeIf(group -> group.getId() == id);
    }
}
