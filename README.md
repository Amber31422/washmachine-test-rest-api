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
The Wash Machine Test REST API is one of a variety of tools and APIs that allow anybody to search and reuse our members' metadata in sophisticated ways.

## API Overview
The API is generally RESTFUL and returns results in JSON. JSON formats returned by the API are documented [here](https://github.com/Crossref/rest-api-doc/blob/master/api_format.md).

The API supports HTTP and HTTPS. Examples here are provided using HTTPS.

You should always url-encode DOIs and parameter values when using the API. DOIs are notorious for including characters that break URLs (e.g. semicolons, hashes, slashes, ampersands, question marks, etc.).

Note that, for the sake of clarity, the examples in this document do *not* url-encode DOIs or parameter values.

The API will only work for Crossref DOIs. You can test the registration agency for a DOI using the following route:

`https://api.crossref.org/works/{doi}/agency`

Testing the following Crossref DOI:

`10.1037/0003-066X.59.1.29`

Using the URL:

`https://api.crossref.org/works/10.1037/0003-066X.59.1.29/agency`

Will return the following result:

    {
      status: "ok",
      message-type: "work-agency",
      message-version: "1.0.0",
      message: {
        DOI: "10.1037/0003-066x.59.1.29",
        agency: {
          id: "crossref",
          label: "Crossref"
        }
      }
    }


## Launch

## API versioning

## Documentation history

