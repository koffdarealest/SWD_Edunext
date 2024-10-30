package group3.edunext.services.implement;

import group3.edunext.models.Class;
import group3.edunext.models.Material;
import group3.edunext.repositories.IClassReposotory;
import group3.edunext.repositories.IMaterialRepository;
import group3.edunext.services.IMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MaterialService implements IMaterialService {
    private  final IMaterialRepository materialRepository;
    private final IClassReposotory classRepository;
    @Override
    public List<Material> GetCurrentMaterial(int userId) {
        List<Material> result = new ArrayList<Material>();
        result = materialRepository.getMaterialsByUserId(userId);
        return result;
    }

    @Override
    public void UploadMaterial(int userId, String MaterialName, String MaterialType) {
        Material material = new Material();
        material.setMaterialName(MaterialName);
        material.setMaterialType(MaterialType);
        materialRepository.save(material);
    }

    @Override
    public Path DownloadMaterial(int MaterialId) {
        Material material = materialRepository.findById(MaterialId).get();
        if (material!=null) {
            return Path.of("C:/Download/"+ material.getMaterialName());
        }
        return null;
    }

    @Override
    public void AssignMaterial(int MaterialId, int ClassId) {
        Material material = materialRepository.getMaterialById(MaterialId).get();

        if (material!=null && classRepository.findById(ClassId).get()!=null) {
            String accessClass = material.getClassIDs() + classRepository.findById(ClassId).get().getId();
            material.setClassIDs(accessClass);
            materialRepository.save(material);
        }
    }
}
