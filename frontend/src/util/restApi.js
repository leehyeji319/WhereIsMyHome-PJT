import axios from "axios";
//base url 설정
export default axios.create({
  baseURL: "http://localhost:10055",
});