package tn.iit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.iit.dao.CompteDao;
import tn.iit.entity.Compte;
import tn.iit.exception.CompteNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class CompteService {

    private final CompteDao compteDao;

    public List<Compte> findAll() {
        return compteDao.findAll();
    }


    public void saveOrUpdate(Compte compte) {
        compteDao.save(compte);
    }

    public void delete(Integer rib) {
        compteDao.deleteById(rib);
    }

    public Compte findById(Integer rib) {
        return compteDao.findById(rib).orElseThrow(() -> new CompteNotFoundException(rib.toString()));
    }


/*	public List<Compte> findAllByName(String name) {
		return students.stream().filter(std -> std.getName().startsWith(name)).collect(Collectors.toList());
	}
*/
}
