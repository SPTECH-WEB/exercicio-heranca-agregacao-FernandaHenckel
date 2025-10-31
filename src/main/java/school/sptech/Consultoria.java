package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor>desenvolvedores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() == vagas) {
            return;
        }
        desenvolvedores.add(desenvolvedor);
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;

        for (Desenvolvedor d : desenvolvedores) {
            soma += d.calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer desenvMobile = 0;

        for (Desenvolvedor d : desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) {
                desenvMobile += 1;
            }
        }
        return desenvMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor>salarioMaior= new ArrayList<>();

        for(Desenvolvedor d : desenvolvedores){
            if (d.calcularSalario() >= salario){
                salarioMaior.add(d);
            }
        }
        return salarioMaior;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor menorSalario = desenvolvedores.get(0);

        for(Desenvolvedor d : desenvolvedores){
            if(menorSalario.calcularSalario() > d.calcularSalario()){
                menorSalario = d;
            }
        }
        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> buscarTecnologia = new ArrayList<>();

        for(Desenvolvedor d : desenvolvedores){

            if (d instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb w = (DesenvolvedorWeb) d;
                if ((w.getFrontend() != null && w.getFrontend().equalsIgnoreCase(tecnologia))
                        || (w.getBackend() != null && w.getBackend().equalsIgnoreCase(tecnologia))
                        || (w.getSgbd() != null && w.getSgbd().equalsIgnoreCase(tecnologia))) {
                    buscarTecnologia.add(d);
                }
            }
            if (d instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile m = (DesenvolvedorMobile) d;
                if ((m.getPlataforma() != null && m.getPlataforma().equalsIgnoreCase(tecnologia))
                        || (m.getLinguagem() != null && m.getLinguagem().equalsIgnoreCase(tecnologia))) {
                    buscarTecnologia.add(d);
                }
            }
        }
        return buscarTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double somarSalario = 0.0;

        for(Desenvolvedor d : desenvolvedores){

            if (d instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb w = (DesenvolvedorWeb) d;
                if ((w.getFrontend() != null && w.getFrontend().equalsIgnoreCase(tecnologia))
                        || (w.getBackend() != null && w.getBackend().equalsIgnoreCase(tecnologia))
                        || (w.getSgbd() != null && w.getSgbd().equalsIgnoreCase(tecnologia))) {
                    somarSalario += d.calcularSalario();
                }
            }
            if (d instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile m = (DesenvolvedorMobile) d;
                if ((m.getPlataforma() != null && m.getPlataforma().equalsIgnoreCase(tecnologia))
                        || (m.getLinguagem() != null && m.getLinguagem().equalsIgnoreCase(tecnologia))) {
                    somarSalario += d.calcularSalario();
                }
            }
        }
        return somarSalario;
    }
}
