import axios from "axios";


const errorHandler = error => {

  console.log(Object.keys(error));
  alert(error.response === undefined ? error.message : error.response.data.message)
};

export const getDataNew = (objectType) => {

  return axios.get(`http://localhost:8080/api/${objectType}`).then(res => res.data);

};
export const getData = (objectType, setStateHandler) => {
  return axios.get(`http://localhost:8080/api/${objectType}`).then(setStateHandler);

};

export const onDelete = (objectType, setStateHandler, id) => {
  const promises = [];
  id.forEach(value => {
    const url = `http://localhost:8080/api/${objectType}/${value}`;
    promises.push(axios.delete(url));
  });
  Promise.all(promises).then(() => {
    getData(objectType, setStateHandler)
  }).catch(errorHandler);
};

export const onAdd = (objectType, setStateHandler, object) => {
  const url = `http://localhost:8080/api/${objectType}`;
  axios.post(url, object).then(() => {
    getData(objectType, setStateHandler)
  }).catch(errorHandler);

};

export const onAddList = (objectType, setStateHandler, objectList) => {
  const url = `http://localhost:8080/api/${objectType}/list`;
  axios.post(url, objectList).then(() => {
    getData(objectType, setStateHandler)
  }).catch(errorHandler);

};

export const onUpdate = (objectType, setStateHandler, object) => {
  const url = `http://localhost:8080/api/${objectType}`;
  axios.put(url, object).then(() => {
    getData(objectType, setStateHandler)
  }).catch(errorHandler);

};

export const getBindedApi = (apiId, callback) =>{
     return {
       getData:getData.bind(this,apiId,callback),
       onDelete:onDelete.bind(this,apiId,callback),
       onAdd:onAdd.bind(this,apiId,callback),
       onAddList:onAddList.bind(this,apiId,callback),
       onUpdate:onUpdate.bind(this,apiId,callback),
     }
};