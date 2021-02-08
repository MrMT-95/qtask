package com.company.qtask.role;

import com.company.qtask.user.User;
import com.company.qtask.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;
    UserRepository userRepository;

    public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addRole(RoleRequest roleRequest) {
        String name = roleRequest.getName();
        Role role = new Role(name);
        roleRepository.save(role);
        throw new ResponseStatusException(HttpStatus.OK,"Role added successfully");
    }

    @Override
    public Iterable<RoleResponse> getRoles() {

        return roleRepository.findAll().stream()
                .map(Role::toRoleResponse)
                .peek(roleResponse -> roleResponse.setUsers(
                        userRepository.findAllByRoleName(roleResponse.getName()).stream()
                                .map(User::toUserResponseForRole)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(RoleRequest roleRequest) {
        roleRepository.delete(roleRepository.findRoleByName(roleRequest.getName()).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given role does not exist!");
        }));
        throw new ResponseStatusException(HttpStatus.OK, "Role deleted successfully");
    }
}
