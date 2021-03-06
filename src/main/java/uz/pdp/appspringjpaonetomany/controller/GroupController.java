package uz.pdp.appspringjpaonetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringjpaonetomany.entity.Faculty;
import uz.pdp.appspringjpaonetomany.entity.Group;
import uz.pdp.appspringjpaonetomany.payload.GroupDto;
import uz.pdp.appspringjpaonetomany.repository.FacultyRepository;
import uz.pdp.appspringjpaonetomany.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;


    //VAZIRLIK UCHUN
    //READ
    @GetMapping
    public List<Group> getGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }


    //UNIVERSITET MAS'UL XODIMI UCHUN
    @GetMapping("/byUniversityId/{universityId}")
    public List<Group> getGroupsByUniversityId(@PathVariable Integer universityId) {
        List<Group> allByFaculty_universityId = groupRepository.findAllByFaculty_UniversityId(universityId);
        List<Group> groupsByUniversityId = groupRepository.getGroupsByUniversityId(universityId);
        List<Group> groupsByUniversityIdNative = groupRepository.getGroupsByUniversityIdNative(universityId);
        return allByFaculty_universityId;
    }



    @PostMapping
    public String addGroup(@RequestBody GroupDto groupDto) {

        Group group = new Group();
        group.setName(groupDto.getName());

        Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDto.getFacultyId());
        if (!optionalFaculty.isPresent()) {
            return "Such faculty not found";
        }

        group.setFaculty(optionalFaculty.get());

        groupRepository.save(group);
        return "Group added";
    }



    @PutMapping("/editGroup/{id]")
    public String editedGroup(@PathVariable Integer id,@RequestBody GroupDto groupDto){
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if(optionalGroup.isPresent()){
            Group group = optionalGroup.get();
            group.setName(groupDto.getName());

            Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDto.getFacultyId());
            if(!optionalFaculty.isPresent()){
                return "Faculty not found";
            }
            Faculty faculty = optionalFaculty.get();
            group.setFaculty(faculty);
            groupRepository.save(group);
            return "Group edited";
        }
        return null;
    }


}
