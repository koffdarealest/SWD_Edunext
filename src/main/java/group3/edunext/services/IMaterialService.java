package group3.edunext.services;

import group3.edunext.models.Material;

import java.nio.file.Path;
import java.util.List;

public interface IMaterialService {
    List<Material> GetCurrentMaterial(int userId);
    void UploadMaterial(int userId, String MaterialName, String MaterialType);
    Path DownloadMaterial(int MaterialId);
    void AssignMaterial(int MaterialId, int ClassId);
}
