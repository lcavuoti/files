package uebungen_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Module {
    private String module;
    private List<Double> gradeList;
    private DoubleSummaryStatistics stats;

    public Module() {
        this.module = "module";
        this.gradeList = new ArrayList<>();
    }

    /**
     * convenience constructor
     * @param grades
     */
    public Module(String... grades) {
        this();
        // the name
        this.module = grades[0];
        // set the grades! skip the title!
        this.gradeList = Arrays.stream(grades, 1, grades.length)
                .map(g -> Double.parseDouble(g))
                .collect(Collectors.toList());
        // set the stats->DoubleSummaryStatistics
        stats = gradeList.stream()
                //.map(g -> g.doubleValue())
                //.mapToDouble(g->g.doubleValue())
                .collect(Collectors.summarizingDouble(Double::doubleValue));
                /*.collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);
                        */

    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<Double> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Double> gradeList) {
        this.gradeList = gradeList;
    }

    public DoubleSummaryStatistics getStats() {
        return stats;
    }

    public void setStats(DoubleSummaryStatistics stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Module{" +
                "module='" + module + '\'' +
                ", gradeList=" + gradeList +
                '}';
    }
}
