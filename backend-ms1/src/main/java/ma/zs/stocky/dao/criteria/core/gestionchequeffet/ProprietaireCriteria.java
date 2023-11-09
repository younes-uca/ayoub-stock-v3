package  ma.zs.stocky.dao.criteria.core.gestionchequeffet;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProprietaireCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String code;
    private String codeLike;



    public ProprietaireCriteria(){}

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


}
