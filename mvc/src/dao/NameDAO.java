package dao;

import vo.BoyVO;
import vo.GirlVO;
import vo.NameDTO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class NameDAO {

    public ArrayList<BoyVO> boys;
    public ArrayList<GirlVO> girls;


    // path1 : 기존 남자 아이 파일 경로
    // path2 : 기존 여자 아이 파일 경로
    // path3 : 병합된 내용을 출력할 경로

    public void merge(String path1, String path2, String path3) throws IOException {
        // 남자 정보 저장
        // 여자 정보 저장
        // 새로운 파일 생성후 출력
        String line = null;
        String temp = "";
        boys = new ArrayList<BoyVO>();
        girls = new ArrayList<GirlVO>();
        BoyDAO boyDAO = new BoyDAO();
        GirlDAO girlDAO = new GirlDAO();
        BufferedReader boyReader = DBConnector.getReader(path1);


        while ((line = boyReader.readLine()) != null) {
            temp += line + "\n";
            boys.add(boyDAO.setModel(line));
        }

        boyReader.close();

        BufferedReader girlReader = DBConnector.getReader(path2);


        while ((line = girlReader.readLine()) != null) {
            temp += line + "\n";
            girls.add(girlDAO.setModel(line));
        }

        girlReader.close();

        BufferedWriter bw = DBConnector.getWriter(path3);
        bw.write(temp);
        bw.close();
    }

    public void update(String path) throws IOException {
        ArrayList<Object> datas = new ArrayList<Object>();
        ArrayList<Integer> populations = new ArrayList<Integer>();
        HashSet<Integer> populationSet = null;
        int ranking = 1;
        String temp = "";
        int count = 0;
        datas.addAll(boys);
        datas.addAll(girls);

        boys.stream().map(v -> v.getPopulation()).forEach(populations::add);
        girls.stream().map(v -> v.getPopulation()).forEach(populations::add);

        populationSet = new HashSet(populations);
        populations = new ArrayList<Integer>(populationSet);
//        Collections.sort(populations);
        populations = (ArrayList<Integer>) populations.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for (Integer population : populations) {
            count = 0;
            for (Object vo : datas) {
                if (vo instanceof BoyVO) {
                    BoyVO boyVO = (BoyVO) vo;
                    if (boyVO.getPopulation() == population) {
                        NameDTO results = new NameDTO();
                        results.setName(boyVO.getName());
                        results.setRanking(ranking);
                        results.setPopulation(boyVO.getPopulation());
                        results.setGender("M");
                        temp += results;
                        count++;
                    }
                }
                if (vo instanceof GirlVO) {
                    GirlVO girlVO = (GirlVO) vo;
                    if (girlVO.getPopulation() == population) {
                        NameDTO results = new NameDTO();
                        results.setName(girlVO.getName());
                        results.setRanking(ranking);
                        results.setPopulation(girlVO.getPopulation());
                        results.setGender("W");
                        temp += results;
                        count++;
                    }
                }


            }
            if (count > 1) {
                ranking += count - 1;
            }
            ranking++;

        }
        BufferedWriter bw = DBConnector.getWriter(path);
        bw.write(temp);
        bw.close();
    }

}
