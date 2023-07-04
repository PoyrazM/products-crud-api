package com.poyrazm.productscrudapi.mapper

interface IMapper<Response, Request, Entity> {
    fun entityToResponse(entity: Entity) : Response
    fun responseToEntity(response: Response) : Entity
    fun requestToEntity(request: Request) : Entity
    fun entityListToResponseList(entity: List<Entity>) : List<Response>
    fun updateRequestToEntity(request: Request, entity: Entity)
}



