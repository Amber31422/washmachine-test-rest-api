# Wash Machine Test REST API
<!-- TOC depthFrom:1 depthTo:2 withLinks:1 updateOnSave:1 orderedList:0 -->

[Wash Machine Test REST API](#washmachine-test-rest-api)
- [Preamble](#preamble)
- [API overview](#api-overview)
- [Launch](#launch)
- [API versioning](#api-versioning)
- [Documentation history](#documentation-history)
	
<!-- TOC depthFrom:1 depthTo:2 withLinks:1 updateOnSave:1 orderedList:0 -->

## Preamble
The Wash Machine Test REST API is one test API that provides the possibility of remote control of different washing machine actions.

## API Overview
The API is generally RESTFUL and returns results in JSON. The API supports HTTP and HTTPS. 

The API provides commands to remote start, stop and wash program changing.

The API will only work for Crossref DOIs. You can test the registration agency for a DOI using the following route:

###Examples

Using the URL:

`http://localhost:8080/washmachines`

Will return the following result:

    {
      {
       "id": 1,
       "modelName": "EFLS627UTT",
       "washCycle": null,
       "washMachineState": {
          "spin": 0,
          "temperature": 0,
          "runningState": "TURNED_ON",
          "activeWashCycleElement": null
        }
      },
    {
       "id": 2,
       "modelName": "EFLS627UTT",
       "washCycle": null,
       "washMachineState": {
           "spin": 0,
           "temperature": 0,
           "runningState": "WAITING",
           "activeWashCycleElement": null
        }
     }
   




## API versioning

## Documentation history

